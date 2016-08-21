(ns humidor-server.model.db
  (:require [korma.db]
            [korma.core]
;            [environ.core :refer [env]]
            ))

; TODO: read from env
(def database-file "/tmp/db.h2")

(korma.db/defdb 
  db 
  (korma.db/h2 
    {:db database-file}))

(korma.core/defentity readings)
