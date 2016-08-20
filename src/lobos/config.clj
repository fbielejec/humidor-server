;;
;;---@fbielejec
;;

(ns lobos.config
  (:use lobos.connectivity)
  (:require [humidor-server.model.database :as database])
  )


;(def db
;  {:classname "org.postgresql.Driver"
;   :subprotocol "postgresql"
;   :user "test"
;   :password "test123"
;   :subname "//localhost:5432/test"})


(def db {:classname "org.h2.Driver"
         :subprotocol "h2"
         :subname database/database-file})


(open-global db)
