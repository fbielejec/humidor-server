;
;---@fbielejec
;

(ns humidor-server.database-tests
  (:require [clojure.test :refer :all]
            [lobos.core :as lobos]
            [korma.core :as k]
            [humidor-server.model.db :as db]
            [humidor-server.model.database :as database]
            [humidor-server.model.time :as t]))

;(def test-row {:time (t/get-now) :h 65.0 :t 21.0})

(defn db-fixture 
  "fixture that is run for each test.
(1) reset the test database by calling rollback
(2) create the schema by apply ingthe defined migrations
(3) insert a test row
(4) call the passed function"
  [test-fn]
  (lobos/rollback :all)
  (lobos/migrate)
  ;  (database/insert test-row)
  (test-fn))

; fixture is run for each test
(use-fixtures :each db-fixture)


(deftest database-insert-tests
  (testing "Testing simple insert"
           (let [test-row {:time (t/get-now) :h 65.0 :t 21.0}]
             (database/insert test-row)
             (is (=
                   test-row
                   (first (database/select-all)))))))


(deftest round-insert-tests
  (testing "inserting one more entry than the desired capcity overwrites first element in database"
           (let [last-value db/capacity]
             (doall
               (map (fn [x] 
                      (database/insert {:time x :h x :t x})) 
                    (range 0 last-value)))
             
             (let [ first-row (first (database/select-all))]
               (is (=
                     first-row
                     {:time last-value :h last-value :t last-value}))))))
