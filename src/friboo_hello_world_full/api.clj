(ns friboo-hello-world-full.api
  (:require [org.zalando.stups.friboo.system.http :refer [def-http-component]]
            [org.zalando.stups.friboo.ring :refer :all]
            [org.zalando.stups.friboo.log :as log]
            [org.zalando.stups.friboo.config :refer [require-config]]
            [io.sarnowski.swagger1st.util.api :refer [throw-error]]
            [ring.util.response :refer :all]))

; define the API component and its dependencies
(def-http-component API "api/api.yaml" [])

(def default-http-configuration
  {:http-port 8080})

(defn throw-ex-info
  "Throws `ex-info` for HTTP 500 with error description inside."
  [e]
  (log/error e (str e))
  (throw (ex-info "Internal server error" {:http-code 500 :details (str e)})))

(defmacro wrap-handler
  "Common part for every handler function, including content-type-json and nice exception handling."
  [& body]
  `(content-type-json
     (try
       ~@body
       (catch Exception e#
         (throw-ex-info e#)))))

(defn get-hello
  "Says hello"
  [{:keys [name] :as params} request]
  (wrap-handler
    (log/warn "Hello called for" name)
    (response {:message (str "Hello " name)})))
