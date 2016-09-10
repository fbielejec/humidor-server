;;
;;---@fbielejec
;;

(ns humidor-server.controller.handler
  (:require [compojure.core :refer [routes defroutes GET POST]]
            [ring.middleware.json :refer [wrap-json-params]]
            [compojure.route :as route]
            [ring.util.response :as response]
            [clj-json.core :as json]
            [humidor-server.model.database :as database]
            [humidor-server.model.time :as t]
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
        (let [row {:time (t/get-now) :h h :t t}]
          (database/insert row)
          (json-response row)
          )
        )
  
    (GET "/arduino" []
       (try
         (json-response (database/select-all))
         (catch Exception e
           (json-response {"Error" "Cannot retrieve readings from database"} 404)
           )))
  
  )


(def app
  (-> (routes arduino-route home-route)
    wrap-json-params))

