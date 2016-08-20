;;
;;---@fbielejec
;;

(ns lobos.migrations
  (:refer-clojure :exclude [alter drop double float time bigint boolean char])
  (:use (lobos [migration :only [defmigration]] core schema config))
  (:require [humidor-server.model.database :as database])
  )

;(def table-name :readings)

(defmigration add-readings-table
  (up [] (create
           (table :readings
                  (integer :time :not-null)
                  (double :h :not-null)
                  (double :t :not-null)
                  )))
  (down [] (drop
             (table :readings))))
