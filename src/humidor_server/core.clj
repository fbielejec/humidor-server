;;
;;---@fbielejec
;;


(ns humidor-server.core
  (:require  [ring.adapter.jetty :as container]
             [environ.core :refer [env]]
             [lobos.core :as lobos]
             [humidor-server.controller.handler :as handler]
             
             )
  (:gen-class))

(def application handler/app)

(defn init 
  "initializes the db and creates the schema if not existing"
  []
  (println "humidor-server is starting")
  (if-not (.exists (java.io.File. "/tmp/database.h2"))
    (lobos/migrate))
  )

(defn start [port]
  (init)
  (container/run-jetty application {:port port}))

(defn -main
  "Entry point. Runs the container on the port specified as
   the first argument or in the PORT global env variable or defaults to 8080"
  [& [port]]
  (let [port (Integer. (or port (env :port) 8080))]
    (start port)))
