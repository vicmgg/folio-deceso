(ns folio-deceso.viz
  (:require [oz.core :as oz]))


(defn chart1-line-plot
  [data-points x-key y-key z-key]
  {:data {:values data-points}
   :width 900
   :height 400
   :encoding {:x {:field x-key
                  :type "temporal"
                  :axis {:format "%b"
                         :tickBand "extent"
                         :tickCount 12
                         :labelFlush "10"}
                  :title nil}
              :y {:field y-key :type "quantitative"
                  :title nil
                  :axis {}}
              :strokeDash {:field :predicted :type "nominal" :title nil
                           :legend nil}
              :color {:field z-key
                      :type "nominal"
                      :scale {:domain ["2016" "2017" "2018" "2019" "2020"]
                              :range ["lightgray" "lightgray""lightgray" "lightgray" "crimson"]}
                      :title nil}}
   :mark {:type "line" :point false}
   :config {:axis {:grid true}
            :backgrounr "white"}})





(defn grouped-bar-chart
  [data-points x-key y-key z-key]
  {:data {:values data-points}
   :width 100
   :height 250
   :encoding {:x {:field x-key :type "ordinal"
                  :sort ["Jan/31/2020"
                         "Feb/28/2020"
                         "Mar/31/2020"
                         "Apr/30/2020"
                         "May/31/2020"]}
              :y {:field y-key :type "quantitative"}
              :column {:field z-key :type "ordinal" :spacing 10}
              :color {:field z-key :type "nominal"
                      :scale {:domain ["2016" "2017" "2018" "2019" "2020"]
                              :range ["lightgray" "lightgray""lightgray" "gray" "crimson"]}}}
   :mark "bar"
   :config {:views {:stroke "transparent"}
            :axis {:grid true, :tickBand "extent"
                   :domainWidtn 1}
            :background "white"}})


(defn grouped-bar-chart-avg
  [data-points x-key y-key z-key]
  {:data {:values data-points}
   :width 125
   :height 250
   :encoding {:x {:field x-key :type "ordinal"
                  :sort ["Jan/31/2020"
                         "Feb/28/2020"
                         "Mar/31/2020"
                         "Apr/30/2020"
                         "May/31/2020"]}
              :y {:field y-key :type "quantitative"}
              :column {:field z-key :type "ordinal" :spacing 10}
              :color {:field z-key :type "nominal"
                      :title nil
                      :legend nil
                      :scale {:domain ["Promedio 2016-2019" "2020"]
                              :range ["gray" "crimson"]}}}
   :mark "bar"
   :config {:views {:stroke "transparent"}
            :axis {:grid true, :tickBand "extent"
                   :domainWidtn 1}
            :background "white"}})




(defn grouped-bar-chart-diff
  [data-points x-key y-key z-key]
  {:data {:values data-points}
   :width 1000
   :height 500
   :encoding {:x {:field x-key
                  :type "ordinal"
                  :title nil
                  :axis {:labelFontSize 14}
                  :sort ["Jan/31/2020"
                         "Feb/28/2020"
                         "Mar/31/2020"
                         "Apr/30/2020"
                         "May/31/2020"]}
              :y {:field y-key :type "quantitative"
                  :title nil
                  :axis {:tickCount 10
                         :labelFontSize 15}}
              :text {:field y-key :type "quantitative" :format ","}
              :column {:field z-key :type "ordinal" :spacing 10
                       :label nil
                       :labels nil
                       :title nil}}
   :layer [{:mark {:type  "bar"
                   :color "crimson"}}
           {:mark {:type "text"
                   :fontSize 14
                   :align "center"
                   :baseline "bottom"
                   :dy -23
                   :fontWeight "bold"
                   :color "black"}}]
   :config {:views {:stroke "transparent"}
            :axis {:grid true, :tickBand "extent"
                   :domainWidtn 1}
            :background "white"}})



(defn grouped-bar-chart-diff-p
  [data-points x-key y-key z-key]
  {:data {:values data-points}
   :width 800
   :height 500
   :encoding {:x {:field x-key :type "ordinal"
                  :title nil
                  :axis {:labelFontSize 14
                         :grid false}
                  :sort ["Jan/31/2020"
                         "Feb/28/2020"
                         "Mar/31/2020"
                         "Apr/30/2020"
                         "May/31/2020"]}
              :y {:field y-key :type "quantitative"
                  :axis {:tickCount 8
                         :grid true
                         :format ".0%"
                         :labelFontSize 15}
                  :title ""}
              :text {:field y-key :type "quantitative"
                     :format ".0%"}
              :column {:field z-key :type "ordinal" :spacing 10
                       :label nil
                       :labels nil
                       :legend nil
                       :title nil}}
   :layer [{:mark {:type "bar"
                   :color "crimson"}}
           {:mark {:type "text"
                   :fontSize 12
                   :align "center"
                   :baseline "bottom"
                   :dy -15
                   :color "black"
                   :fontWeight "bold"}}]
   :config {:views {:stroke "transparent"}
            :axis {:grid true, :tickBand "extent"
                   :domainWidtn 1}
            :background "white"}})




(defn chart4-bar-chart
  [data-points x-key y-key]
  {:data {:values data-points}
   :width 900
   :height 300
   :encoding {:text {:field y-key :type "quantitative" :format ","}
              :y {:field x-key :type "nominal" :title nil
                  :axis {:labelFontSize 14}}
              :x {:field y-key :type "quantitative" :title ""
                  :axis {:labelFontSize 15 :tickCount 5}}}
   :layer [{:mark {:type "bar" :color "#ff4d4d"}}
           {:mark {:type "text"
                   :fontSize 14
                   :align "center"
                   :baseline "middle"
                   :dx 24
                   :color "black"
                   :fontWeight "bold"}}]
   :config {:axis {:grid true, :tickBand "extent"}
            :background "white"
            :color "crimson"}})


(defn chart5-line-plot
  [data-points x-key y-key z-key]
  {:data {:values data-points}
   :width 600
   :height 250
   :layer [
           {:mark {:type "point"
                   :color "crimson"
                   :filled true
                   :shape "circle"
                   :size 60}
            :encoding {:x {:field x-key
                           :type "temporal"
                           :axis {:format " %d/%b "
                                  :tickBand "extent"
                                  :tickCount 7
                                  :labelFlush "10"}
                           :title nil}
                       :y {:field "diff" :type "quantitative"
                           :title nil
                           :axis {}}
                       :strokeDash {:field :predicted :type "nominal" :title nil
                                    :legend nil}}}
           {:mark {:type "line" :point false}
            :encoding {
                       :x {:field x-key
                           :type "temporal"
                           :axis {
                                  :tickBand "extent"
                                  :tickCount 7
                                  :labelFlush "10"}
                           :title nil}
                       :y {:field y-key :type "quantitative"
                           :title nil
                           :axis {}}
                       :color {:field z-key
                               :type "nominal"
                               :scale {:domain ["Confirmados+Sospechosos" "Exceso de Mortalidad"]
                                       :range ["gray" "crimson"]}
                               :legend {:orient "top"
                                        :titleFontSize 14
                                        :titleLimit 800
                                        :labelLimit 800
                                        :labelFontSize 14}
                               :title nil}}}
           {:mark {:type "text"
                   :fontSize 12
                   :align "center"
                   :baseline "middle"
                   :color "crimson"
                   :dx 10
                   :dy -10
                   :fontWeight "bold"}
            :encoding {:x {:field x-key
                           :type "temporal"
                           :title nil}
                       :text {:field "diff" :type "quantitative" }
                       :y {:field "diff" :type "quantitative"
                           :title nil
                           :axis {}}
                       :strokeDash {:field :predicted :type "nominal" :title nil
                                    :legend nil}}}]
   :config {:axis {:grid true}
            ;; :background "#fcf8e8"
            :background "white"}})


(defn single-bar-percent
  [d]
  {:data {:values d}
   :width 200
   :height 10
   :config {:axis {:grid true}
            ;; :background "#fcf8e8"
            :background (if (= (:place d) "CDMX") "pink" "white")}
   :layer [{:mark {:type "bar" :height 10 :color "gray"}
            :encoding {:x {:field "proportion"
                           :type "quantitative"
                           :scale {:domain [0, 100]}
                           :axis {:title nil
                                  :tickCount 0}}}}
           {:mark {:type "text" :fontSize 12 :dx 120 :dy 0
                   :fontWeight "normal"}
            :encoding {:text {:field "proportion", :type "quantitative"}
                       :color {:value "#222222"}}}]})


(defn covid-xss-table
  [places]
  (let [headers ["" "Decesos" "Exceso de mortalidad" "Decesos oficiales por COVID-19" "Decesos oficiales COVID-19 como proporción del exceso de mortalidad (%)"]]
    [:html
     [:head
      [:style (slurp "resources/style.css")]]
     [:body
      [:table {:class "calendar"}
       [:thead
        [:tr
         (map (fn [el] [:th el]) headers)]]
       (map (fn [p] [:tbody
                     [:tr
                      [:td (:place p)]
                      [:td (format "%,d" (:deaths p))]
                      [:td (format "%,d" (:xssdeaths p))]
                      [:td (format "%,d" (:covid-deaths p))]
                      [:td [:vega-lite
                            (single-bar-percent {:place (:place p)
                                                 :proportion
                                                 (int (* 100.0 (/ (:covid-deaths p)
                                                                  (:xssdeaths p))))})]]]])
            places)]]]))



(defn cities-xss-table
  [places]
  (let [headers ["" "Exceso de mortalidad" "Exceso de mortalidad (%)"
                 "Semana inicial" "Semana final" "Exceso de mortalidad/población millones"]]
    [:html
     [:head
      [:style (slurp "resources/style.css")]]
     [:body
      [:table {:class "calendar"}
       [:thead
        [:tr
         (map (fn [el] [:th el]) headers)]]
       (map (fn [p] [:tbody
                     [:tr
                      [:td (:region p)]
                      [:td (format "%,.0f" (float (:xss-net p)))]
                      [:td (format "%,.0f%%" (:xss-pct p))]
                      [:td (:start-week p)]
                      [:td (:end-week p)]
                      [:td (format "%,.0f" (:xss-pop p))]]])
            places)]]]))



(defn weekly-line-plot
  [data-points x-key y-key z-key]
  {:data {:values data-points}
   :width 900
   :height 400
   :layer [{:mark {:type "line"
                   :point false
                   :interpolate "linear"}
            :encoding {:x {:field x-key
                           :title "Semanas"
                           :type "quantitative"
                           :scale {:domain [10 , 52]
                                   :nice false
                                   ;;:range [10, 52]
                                   :tickMinStep 1}
                           :axis {;;:tickBand "extent"
                                  :grid false
                                  :tickCount 42}}
                       :y {:field y-key
                           :axis {:grid true}
                           :type "quantitative"
                           :scale {:domain [1000,4500]}
                           :title "Decesos semanales"}
                       :color {:field z-key
                               :type "nominal"
                               :scale {:domain [2016, 2017, 2018, 2019, 2020, "Promedio", "area"]
                                       :range ["lightgray" "lightgray" "lightgray" "lightgray" "crimson" "gray", "crimson"]}
                               :legend {:orient "right"
                                        :titleFontSize 14
                                        :titleLimit 800
                                        :labelLimit 800
                                        :labelFontSize 14}
                               :title "Año"}}}
           {:mark {:type "line"
                   :point false}
            :encoding {:x {:field x-key
                           :type "quantitative"}
                       :y {:field y-key
                           :type "quantitative"}
                       :color {:field z-key
                               :type "nominal"}}}

           {:mark {:type "area"
                   :point false
                   :color "#222222"
                   :interpolate "linear"}
            :encoding {:opacity {:value 0.25}
                       :x {:field x-key
                           :type "quantitative"}
                       :y {:field :area
                           :axis {:grid true}
                           :type "quantitative"
                           :scale {:domain [1000,4500]}
                           :aggregate "max"}
                       :y2 {:field :avgy
                            :aggregate "min"
                            :type "quantitative"}
                       :color {:field z-key
                               :type "nominal"
                               :scale {:domain ["area"]
                                       :range ["crimson"]}
                               :legend nil
                               :title nil}}}]
   :config {:axis {}
            ;; :background "#fcf8e8"
            :background "white"}})


(defn chart-stacked-cofirmed-xss
  [data-points x-key y-key z-key]
  {:data {:values data-points}
   :width 900
   :height 400
   :layer [{:mark {:type "area"
                   :point false
                   :interpolate "linear"}
            :encoding {:opacity {:value 0.3}
                       :x {:field x-key
                           :title "Semanas"
                           :type "quantitative"
                           :scale {:domain [12, 27]}
                           :axis {;;:tickBand "extent"
                                  :grid false
                                  :domain true
                                  :tickCount 15}}
                       :y {:field y-key
                           :axis {:grid true}
                           :sort ["Decesos confirmados" "Excedente 2020"]
                           :type "quantitative"
                           :scale {:domain [0,3500]}
                           :title "Decesos semanales"}
                       :color {:field z-key
                               :type "nominal"
                               :scale {:domain ["Excedente 2020" "Decesos confirmados"]
                                       :range [ "crimson" "black"]}
                               :legend {:orient "right"
                                        :titleFontSize 14
                                        :titleLimit 800
                                        :labelLimit 800
                                        :labelFontSize 14}
                               :title "Serie"}}}]
   :config {:axis {}
            ;; :background "#fcf8e8"
            :background "white"}})




(defn multiregion-line-plot
  [data-points x-key y-key z-key]
  {:data {:values data-points}
   :width 200
   :height 100
   :encoding {:x {:field x-key
                  :type "temporal"
                  :axis {:format "%b"
                         :tickBand "extent"
                         :tickCount 12
                         :grid false
                         :labelFlush "10"}
                  :title nil}
              :y {:field y-key :type "quantitative"
                  :title "Fallecimientos"
                  :axis {:tickCount 6
                         :grid true
                         :labelFlush "10"}}
              :strokeDash {:field :predicted :type "nominal" :title nil
                           :legend nil}
              :color {:field z-key
                      :type "nominal"
                      :scale {:domain ["expected" "2020"]
                              :range ["gray" "crimson"]}
                      :title nil}
              :facet {:field "region"
                      :type "nominal"
                      :columns 3
                      :title nil
                      :spacing 20}}
   :mark {:type "line" :point false}
   ;;:resolve {:scale {:y "independent"}}
   :config {:axis {}
            :background "white"}})





(defn multi-weekly-line-plot
  [data-points x-key y-key z-key]
  {:data {:values data-points}
   ;;:repeat {:row [:region]}
   :facet {:field "region"
           :type "nominal"
           :columns 3
           :title nil
           :spacing 20}
   :width 200
   :height 200
   :columns 3
   :spec {:layer [{:mark {:type "line"
                          :point false
                          :interpolate "linear"}
                   :encoding {:x {:field x-key
                                  ;;:title "Semanas"
                                  :type "quantitative"
                                  :scale {;;:domain [10 , 52]
                                          :nice false
                                          ;;:range [10, 52]
                                          :tickMinStep 1}
                                  :axis {;;:tickBand "extent"
                                         :grid true
                                         :tickCount 14}}
                              :y {:field y-key
                                  :axis {:grid true}
                                  :type "quantitative"
                                  ;; :scale {:domain [1000,4500]}
                                  :title "Decesos semanales"}
                              :color {:field z-key
                                      :type "nominal"
                                      :scale {:domain ["expected", "2020"]
                                              :range ["gray", "crimson" "crimson"]}
                                      :legend {:orient "right"
                                               :titleFontSize 14
                                               :titleLimit 800
                                               :labelLimit 800
                                               :labelFontSize 14}
                                      :title "Año"}}}
                  {:mark {:type "line"
                          :point false}
                   :encoding {:x {:field x-key
                                  :type "quantitative"}
                              :y {:field y-key
                                  :type "quantitative"}
                              :color {:field z-key
                                      :type "nominal"}}}

                  {:mark {:type "area"
                          :point false
                          :color "#222222"
                          :interpolate "linear"}
                   :encoding {:opacity {:value 0.25}
                              :x {:field x-key
                                  :type "quantitative"}
                              :y {:field :area
                                  :axis {:grid true}
                                  :type "quantitative"
                                  ;;:scale {:domain [000,4500]}
                                  :aggregate "max"}
                              :y2 {:field :avgy
                                   :aggregate "min"
                                   :type "quantitative"}
                              :color {:field z-key
                                      :type "nominal"
                                      :scale {:domain ["area"]
                                              :range ["crimson"]}
                                      :legend nil
                                      :title nil}}}]}
   :config {:axis {}
            ;; :background "#fcf8e8"
            :background "white"}})
