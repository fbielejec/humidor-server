;;
;;---@fbielejec
;;

(ns humidor-server.model.time
  (:require 
    [clj-time.core :as t]
    [clj-time.format :as f]
    [clj-time.local :as l]
    [clj-time.coerce :as c]))

(def custom-formatter (f/formatter "yyyy-MM-dd HH:mm:ss"))

(defn format-time
  "formats date from long to string"
  [time]
  (f/unparse custom-formatter (c/from-long time)))

(defn get-now
  "Returns current time as long"
  []
  (c/to-long
    ;  (l/local-now)
    (t/now)))
