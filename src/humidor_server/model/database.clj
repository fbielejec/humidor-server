;;
;;---@fbielejec
;;

(ns humidor-server.model.database
  (:require [clojure.java.jdbc :as sql]
            [environ.core :refer [env]]
            
            
            ))

; DB
; https://blog.pivotal.io/labs/labs/adventures-clojure-tdd

; DB testing
;http://www.lispcast.com/clojure-database-test-faster

(def db
  (or (System/getenv "DATABASE_URL") "postgresql://localhost:5432/readings"))


(def table-name :readings)

;(def db-spec 
;  {:classname "com.mysql.jdbc.Driver"
;   :subprotocol "mysql"
;   :subname "//127.0.0.1:3306/mydb"
;   :user "myaccount"
;   :password "secret"})


(defn insert 
  "db: database connection string
   row: {:h h :t t}"
  [h t]
  (let [row {:h h :t t}]
    
    (sql/insert! db table-name row )
    
    )
  )



