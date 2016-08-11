(defproject humidor-server "0.1.0-SNAPSHOT"
  :description "REST server for humidor-app"
  :url "http://example.com/FIXME"
  :license {:name "GNU Lesser General Public License"
            :url "https://www.gnu.org/copyleft/lesser.html"}
  :dependencies [
                 [org.clojure/clojure "1.8.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.2.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring-json-params "0.1.3"]
                 [clj-json "0.5.3"]
                 [environ "1.0.0"]
                 
                 
                 ]
  :main ^:skip-aot humidor-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  
  :plugins [
            [no-man-is-an-island/lein-eclipse "2.0.0"]
            [lein-kibit "0.1.2"]
            ]
  
  )
