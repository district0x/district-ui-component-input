(ns district.ui.component.token-input
  (:require [district.ui.component.input :as input]
            [reagent.core :as r]
            [soda-ash.core :as ui]))

(defn token-input [{:keys [token-code] :as props :or {token-code "ETH"}}]
  [input/input
   (r/merge-props
    {:action (r/as-element [ui/Label token-code])}
    (dissoc props :token-code))])
