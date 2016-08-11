;;
;;---@fbielejec
;;

(ns humidor-server.routes.handler
  (:use compojure.core )
  (:use ring.middleware.json-params )
  (:use ring.middleware.params )
  (:require [clj-json.core :as json] )
  (:require [ring.util.response :as response] )
  (:require [compojure.route :as route] )
  
  
  )

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

(defroutes arduino-test-route
  ;; route to test arduino connection
  (POST "/arduinotest" [input]
        (try
          (do
            (println input)
            (json-response input)
            )
          (catch Exception e
            (println "Caught an error: Cannot upload trees")
            (json-response {"Error" "Cannot upload trees file"} (:invalid status-codes) )
            ))))


(def app
  (-> (routes arduino-test-route home-route)
    wrap-json-params 
    ))