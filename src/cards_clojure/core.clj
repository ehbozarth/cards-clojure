(ns cards-clojure.core
  (:gen-class))

(def suits [:clubs :spades :hearts :diamonds]               ;clojure keywords that act as identifiers
  )
(def ranks (range 1 14))                                    ;range of ranks for card values
(def rank-names {1  :ace                                    ;set the rank number to keyword (i.e. ace, jack, queen, king)
                 11 :jack
                 12 :queen
                 13 :king})

(defn create-deck []
  (set (for [suit suits                                     ;double nested for loop rank loop inside suit loop
             rank ranks]
         {:suit suit                                        ;keyword is suit
          :rank (get rank-names rank rank)}                 ;value is the rank/get rank name if inside rank, if does not exist jsut return rank as value
         ))
  )

(defn create-hands [deck]                                   ;avoiding duplicates
  (set (for [c1 deck
         c2 (disj deck c1)                                  ;loop for deck for 2nd card with no repeats of c1
         c3 (disj deck c1 c2)                               ;loop for deck for 3rd card with no repeats of c1, c2
         c4 (disj deck c1 c2 c3)]                           ;loop for deck for 4th card with no repeats of c1, c2, c3
     #{c1 c2 c3 c4}))                                       ;make it a hash set to avoid duplicate hands/sets
  )

(defn flush? [hand]
  (= 1 (count (set (map :suit hand))))                      ;Checks to see if all cards in hand have same suit
  )

(defn -main [& args]
  (let [deck (create-deck)
        hands (create-hands deck)
        hands (filter flush? hands)
        ]
    (println (count hands))
    )
  )
