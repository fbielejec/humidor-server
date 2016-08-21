;;
;;---@fbielejec
;;

(ns humidor-server.routes-tests
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clj-json.core :as json]
            [clojure.walk :as w]
            [humidor-server.controller.handler :as handler]
            ))

(def test-readings { :h 65 :t 21 })

(deftest routes-tests
  (testing "/arduino route test."
           (let [response
                 (handler/app
                   (-> (mock/request
                         :post
                         "/arduino"
                         (json/generate-string test-readings))
                     (mock/content-type "application/json")))]
             
             (is (= (select-keys
                      (-> (:body response)
                        (json/parse-string)
                        (w/keywordize-keys))
                      [:h :t])
                    test-readings)))))
