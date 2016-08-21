;;
;;---@fbielejec
;;

(ns humidor-server.model.database
  (:require
    [korma.core :as k]
    [lobos.core :as lobos] 
    [humidor-server.model.db :as db]))

(defn create
  "Creates the database"
  []
  (lobos/migrate)) 

(defn select-all
  "Returns a list of all rows from the table"
  []
  (k/select db/readings))

(defn insert 
  "update table by inserting a row of values"
  [row]
  (k/insert db/readings (k/values row)))
