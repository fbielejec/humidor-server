;;
;;---@fbielejec
;;

; H2 and Lobos
; http://craigglennie.com/programming/clojure/2015/09/07/unit-testing-with-cursive-clojure/


(ns humidor-server.model.database
  (:require
            [korma.core :as k]
            [lobos.core :as lobos] 
            [humidor-server.model.db :as db] 
            
            ))


(defn create
  "Creates the database"
  []
  (lobos/migrate)
  ) 
  

(defn read-all
  "Return all rows from the table"
  []
  (k/select db/readings)
  )


(defn insert 
  "update table inserting a row {:h h :t t}"
  [h t]
  ; TODO: add a timestamp to row
  (let [row {:h h :t t}]
    
    (k/insert db/readings (k/values row))


    )
  )



