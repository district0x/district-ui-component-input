# district-ui-component-input

[![Build Status](https://travis-ci.org/district0x/district-ui-component-input.svg?branch=master)](https://travis-ci.org/district0x/district-ui-component-input)

Clojurescript [re-mount](https://github.com/district0x/d0x-INFRA/blob/master/re-mount.md) component, which provides input fields.

## Installation
Add `[district0x/district-ui-component-input "1.0.0"]` into your project.clj
Include `[district.ui.component.input]` in your CLJS file for general input field and `[district.ui.component.token-input]` for a token input field.

## API Overview

**Warning:** district0x modules and components are still in early stages, therefore API can change in a future.

- [district.ui.component.input](#input)
- [district.ui.component.token-input](#token-input)

## <a name="input">`district.ui.component.input`
This namespace contains the reagent UI component with an input field. <br>
You can pass following args to this component:

* `:value` Takes input to display in the field.
* `:on-focus` Takes a function to execute when the field comes in focus.
* `:on-blur` Takes a function to execute when the field looses focus.

Usage example:

``` clojure
(ns my-district.core
  (:require [reagent.core :as r]
            [district.ui.component.input :as input]))

(defn input-panel []
  (let [input-value (r/atom "start typing...")]
    (fn []
      [:div.app
       [input/input
        {:label "Input"
         :fluid true
         :value @input-value
         :error (empty? @input-value)
         :on-change #(reset! input-value (aget %2 "value"))}]])))
```

## <a name="token-input">`district.ui.component.token-input`
This namespace contains the reagent UI component with a token input field. <br>
It takes the same arguments as the [input](#input) component, plus:

* `token-code` Takes a string value to display as a label.

Basic example:

```clojure
(ns my-district.core
  (:require [reagent.core :as r]
            [district.ui.component.token-input :as token-input]))

(defn input-panel []
  (let [token-value (r/atom 100)]
    (fn []
      [:div.app
       [token-input/token-input
        {:value @token-value
         :on-change #(reset! token-value (aget %2 "value"))
         :fluid true
         :token-code "DNT"}
        "Value"]])))
```

## Development
```bash
lein deps
# To run tests and rerun on changes
lein doo chrome tests
```
