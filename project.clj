(defproject district0x/district-ui-component-input "1.0.0"
  :description "district UI component which provides styled input fields"
  :url "https://github.com/district0x/district-ui-component-input"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[soda-ash "0.76.0"]
                 [cljsjs/react-with-addons "15.2.0-0"]
                 [org.clojure/clojurescript "1.9.946"]]

  :exclusions [[cljsjs/react]
               [org.clojure/clojure]
               [org.clojure/clojurescript]]

  :npm {:devDependencies [[karma "1.7.1"]
                          [karma-chrome-launcher "2.2.0"]
                          [karma-cli "1.0.1"]
                          [karma-cljs-test "0.1.0"]]}

  :doo {:paths {:karma "./node_modules/karma/bin/karma"}}

  :clean-targets ^{:protect false} ["tests-output"]

  :profiles {:dev {:dependencies [[org.clojure/clojure "1.8.0"]
                                  [hickory "0.7.1"]
                                  [district0x/district-ui-reagent-render "1.0.0"]
                                  [day8.re-frame/test "0.1.5"]
                                  [cljs-react-test "0.1.4-SNAPSHOT"]
                                  [lein-doo "0.1.8"]]
                   :plugins [[lein-npm "0.6.2"]
                             [lein-doo "0.1.8"]]}}

  :cljsbuild {:builds [{:id "tests"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "tests-output/tests.js"
                                   :output-dir "tests-output"
                                   :main "tests.runner"
                                   :optimizations :none}}]})
