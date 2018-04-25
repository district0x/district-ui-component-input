(ns tests.all
  (:require [cljs.test :refer [deftest is testing run-tests async use-fixtures]]
            [cljs.pprint]
            [cljs-react-test.simulate :as simulate]
            [cljs-react-test.utils :as test-utils]
            [hickory.core :as hickory]
            [hickory.select :as s]
            [day8.re-frame.test :refer [run-test-async run-test-sync wait-for]]
            [district.ui.reagent-render]
            [mount.core :as mount :refer [defstate]]
            [re-frame.core :as re-frame]
            [reagent.core :as r]

            [district.ui.component.input :as input]))

(def container (atom nil))

(defn mock-html []
  (let [input-value (r/atom "start typing...")]
    (fn []
      [:div#app [input/input
                 {:label "Input"
                  :fluid true
                  :value @input-value
                  :error (empty? @input-value)
                  :on-change #(reset! input-value (aget %2 "value"))}]])))

(use-fixtures :each
  {:before #(do (reset! container (test-utils/new-container!))
                (-> (mount/with-args {:reagent-render {:target @container
                                                       :component-var #'mock-html}})
                    (mount/start)))
   :after #(do (test-utils/unmount! @container)
               (mount/stop))})

(deftest tests
  (testing "test basic input"
    (async done
           (.setTimeout js/window
                        (fn []
                          ;; TODO: test actions
                          (is (->> @container
                                   .-innerHTML
                                   hickory/parse
                                   hickory/as-hickory
                                   (s/select
                                    (s/child (s/id "app")
                                             (s/nth-child 1)
                                             (s/node-type :element)))
                                   first
                                   :content
                                   second
                                   (= "Input")))
                          (done))
                        1000))))
