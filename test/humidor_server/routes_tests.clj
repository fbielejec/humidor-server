;;
;;---@fbielejec
;;

(ns humidor-server.routes-tests
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clj-json.core :as json]
            [humidor-server.controller.handler :as handler]
            ))


; TODO: assertions on body of the response (should return the same json)
(deftest routes-tests
  
  (testing "/arduino route test."
           
;           (let [response
;                 (handler/app
;                   (-> (mock/request
;                         :post
;                         "/arduino"
;                         (json/generate-string { :h 65 :t 21 }))
;                     (mock/content-type "application/json")))]
;
;           (println response)
;             
;             )
           
           
           )
  
  )
