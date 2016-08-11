;;
;;---@fbielejec
;;

(ns humidor-server.core-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clj-json.core :as json]
            [humidor-server.routes.handler :as handler]
            )
  )

(deftest routes-test
  (testing "/arduino route test."
           
;         (println  (json/generate-string { :h 65 :t 21 }) )
           
(handler/app 
                 (-> (mock/request
                       :post
                       "/arduino"
                       (json/generate-string { :h 65 :t 21 }))
                   
                   (mock/content-type "application/json")
                   
                   )
                 
                 )
           
           )
  
  
  )
