;;
;;---@fbielejec
;;

(ns humidor-server.controller.routes-handler
  (:require [compojure.core :refer [routes defroutes GET POST]]
            [ring.middleware.json :refer [wrap-json-params]]
            [compojure.route :as route]
            [ring.util.response :as response]
            [clj-json.core :as json]
            [humidor-server.model.database :as database]
            ))


(def status-codes
  {:invalid 400
   :not-found 404
   :ok 200})


(defn json-response [data & [status]]
  {
   :status (or status (:ok status-codes))
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)
   })


(defroutes home-route
  (GET "/" [] (response/resource-response "index.html" {:root "public"}))
  (route/resources "/")
  (route/not-found "Page not found"))


(defroutes arduino-route
  ;; route to test arduino connection
  (POST "/arduino" [h t]
        (json-response (database/insert h t))))


(def app
  (-> (routes arduino-route home-route)
    wrap-json-params))

