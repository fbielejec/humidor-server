;;
;;---@fbielejec
;;


(ns humidor-server.core
  
  (:require  [ring.adapter.jetty :as container]

             [humidor-server.controller.routes-handler :as routes-handler]
             
    )
  (:gen-class))

;(def port
;  (Integer. (or (System/getenv "PORT") "8080")))

(def application routes-handler/app)


(defn start [port]
  (container/run-jetty application {:port port}))


(defn -main
  "Entry point. Runs the container on the port specified as
   the first argument or in the PORT global env variable or defaults to 8080"
  [& [port]]
  (let [port (Integer. (or port (env :port) 8080))]
    (start port)))



