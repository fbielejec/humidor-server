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
   (:require [humidor-server.persistance.database :as database] )
  
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

(defroutes arduino-route
  ;; route to test arduino connection
   (POST "/arduino" [h t]
   
         (println h t)
  
         (database/handle-upload [h t]) 
          
  )
  )


(def app
  (-> (routes arduino-route home-route)
    wrap-json-params 
    ))