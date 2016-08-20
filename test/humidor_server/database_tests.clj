;
;---@fbielejec
;

(ns humidor-server.database-tests
  (:require [clojure.test :refer :all]
            [lobos.core :as lobos]
            [korma.core :as k]
            [humidor-server.model.db :as db]
            ; TODO: call f-tions from this ns:
            [humidor-server.model.database :as database]
            ))


(defn db-fixture 
  "fixture that is run for each test.
(1) reset the test database by calling rollback
(2) create the schema by apply ingthe defined migrations
(3) insert a test row
(4) call the passed function"
  [test-fn]
  (lobos/rollback :all)
  (lobos/migrate)
  (database/insert {:time 1 :h 65.0 :t 21.0})
  (test-fn))


; fixture is run for each test
(use-fixtures :each db-fixture)


(deftest database-tests
  
  (testing "Testing db upload"
           
           (is (=
                 {:time 1 :h 65.0 :t 21.0}
                (first (database/select-all))))
           )
  
  
  
  )






