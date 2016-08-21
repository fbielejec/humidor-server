;;
;;---@fbielejec
;;

(ns humidor-server.time-tests
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [humidor-server.model.time :as t]
            ))

(deftest time-tests
  (testing "get-now returns timestamp as Long"
           (is (=
                 (instance? java.lang.Long (t/get-now))  
                 true))))
