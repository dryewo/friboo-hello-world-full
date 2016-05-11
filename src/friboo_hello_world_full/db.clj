(ns friboo-hello-world-full.db
  (:require [yesql.core :refer [defqueries]]
            [org.zalando.stups.friboo.system.db :refer [def-db-component generate-hystrix-commands]]))

(def-db-component DB :auto-migration? true)

(def default-db-configuration
  {:db-classname   "org.postgresql.Driver"
   :db-subprotocol "postgresql"
   :db-subname     "//docker:5432/postgres"
   :db-user        "postgres"
   :db-password    "postgres"
   :db-init-sql    "SET search_path TO fh_data, public"})

(defqueries "db/queries.sql")
(generate-hystrix-commands)
