; Copyright 2015 Zalando SE
;
; Licensed under the Apache License, Version 2.0 (the "License")
; you may not use this file except in compliance with the License.
; You may obtain a copy of the License at
;
;     http://www.apache.org/licenses/LICENSE-2.0
;
; Unless required by applicable law or agreed to in writing, software
; distributed under the License is distributed on an "AS IS" BASIS,
; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
; See the License for the specific language governing permissions and
; limitations under the License.

; Copyright 2013 Stuart Sierra
;
; The use and distribution terms for this software are covered by the Eclipse Public License 1.0.
;    http://opensource.org/licenses/eclipse-1.0.php

(ns user
  "Tools for interactive development with the REPL. This file should
  not be included in a production build of the application."
  (:require [clojure.java.javadoc :refer [javadoc]]
            [clojure.pprint :refer [pprint]]
            [clojure.reflect :refer [reflect]]
            [clojure.repl :refer [apropos dir doc find-doc pst source]]
            [clojure.tools.namespace.repl :refer [refresh refresh-all]]
            [com.stuartsierra.component :as component]
            [clojure.test :refer [run-all-tests]]
            [friboo-hello-world-full.core :as core]))

(def system
  "A Var containing an object representing the application under
  development."
  nil)

(defn start
  "Starts the system running, sets the Var #'system."
  [extra-config]
  (alter-var-root #'system (constantly (core/run (merge {:system-log-level "INFO"}
                                                        extra-config)))))

(defn stop
  "Stops the system if it is currently running, updates the Var
  #'system."
  []
  (alter-var-root #'system
                  (fn [s] (when s (component/stop s)))))

(defn go
  "Initializes and starts the system running."
  ([extra-config]
   (start extra-config)
   :ready)
  ([]
   (go {})))

(defn reset
  "Stops the system, reloads modified source files, and restarts it."
  []
  (stop)
  (refresh :after 'user/go))

(defn run-tests []
  (run-all-tests #"friboo-hello-world-full.*-test"))

(defn tests
  "Stops the system, reloads modified source files and runs tests"
  []
  (stop)
  (refresh :after 'user/run-tests))
