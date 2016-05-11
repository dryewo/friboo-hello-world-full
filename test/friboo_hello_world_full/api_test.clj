(ns friboo-hello-world-full.api-test
  (:require
    [clojure.test :refer :all]
    [friboo-hello-world-full.db :as db]
    [friboo-hello-world-full.api :refer :all]))

(deftest can-get-hello
  (is (= (get-hello {:name "Friboo"} nil nil)
         {:status  200
          :headers {"Content-Type" "application/json"}
          :body    {:message "Hello Friboo"}})))

(deftest can-delete-greeting-template
  (let [number-of-calls (atom 0)]
    (with-redefs [db/cmd-delete-greeting!
                  (fn [data conn]
                    (swap! number-of-calls inc)
                    (is (= data {:id "foo"}))
                    (is (= conn {:connection "db-conn"})))]
      (is (= (delete-greeting-template {:greeting_id "foo"} nil "db-conn")))
      (is (= @number-of-calls 1)))))
