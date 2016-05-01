(defproject friboo-hello-world-full "0.1.0-SNAPSHOT"
  :description "Example project featuring all the friboo components"
  :url "https://github.com/dryewo/friboo-hello-world-full"
  :license {:name "The Apache License, Version 2.0"
            :url  "http://www.apache.org/licenses/LICENSE-2.0"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.zalando.stups/friboo "1.7.0"]
                 [yesql "0.5.2"]]
  :main ^:skip-aot friboo-hello-world-full.core
  :uberjar-name "friboo-hello-world-full.jar"
  :plugins [[io.sarnowski/lein-docker "1.1.0"]
            [org.zalando.stups/lein-scm-source "0.2.0"]]
  :docker {:image-name #=(eval (str (some-> (System/getenv "DEFAULT_DOCKER_REGISTRY")
                                      (str "/"))
                                 "example_team/friboo-hello-world-full"))}
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag"]
                  ["clean"]
                  ["uberjar"]
                  ["scm-source"]
                  ["docker" "build"]
                  ["docker" "push"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["echo" "-e" "Now run:\\n\\n    lein vcs push\\n"]
                  #_["vcs" "push"]]
  :profiles {:uberjar {:aot :all}
             :dev     {:repl-options {:init-ns user}
                       :source-paths ["dev"]
                       :dependencies [[org.clojure/tools.namespace "0.2.11"]
                                      [org.clojure/java.classpath "0.2.3"]]}})
