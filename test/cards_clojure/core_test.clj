(ns cards-clojure.core-test
  (:require [clojure.test :refer :all]
            [cards-clojure.core :refer :all]))


(def hand-1 #{{:suit :clubs
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank :queen}
              {:suit :clubs
               :rank :king}
              })

(def hand-2 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank :queen}
              {:suit :clubs
               :rank :king}
              })

(deftest flush-test
  (testing "Flush Return True if Hand is A Flush"
    (is (= true (flush? hand-1)))
    (is (= false (flush? hand-2)))))


(def hand-3 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :spades
               :rank 2}
              {:suit :hearts
               :rank 2}
              })

(def hand-4 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :spades
               :rank 3}
              {:suit :hearts
               :rank 2}
              })

(deftest four-of-a-kind-test
  (testing "Four of a Kind Return True if Hand is A Four of a Kind"
    (is (= true (n-of-a-kind? 4 hand-3)))
    (is (= false (n-of-a-kind? 4 hand-4)))))

(def hand-5 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :spades
               :rank 5}
              {:suit :hearts
               :rank 2}
              })

(def hand-6 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 5}
              {:suit :spades
               :rank 3}
              {:suit :hearts
               :rank 2}
              })

(deftest three-of-a-kind-test
  (testing "Three of a Kind Return True if Hand is A Three of a Kind"
    (is (= true (n-of-a-kind? 3 hand-5)))
    (is (= false (n-of-a-kind? 3 hand-6)))))


(def hand-7 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 9}
              {:suit :spades
               :rank 5}
              {:suit :hearts
               :rank 2}
              })

(def hand-8 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 5}
              {:suit :spades
               :rank 3}
              {:suit :hearts
               :rank 9}
              })

(deftest two-of-a-kind-test
  (testing "Two of a Kind Return True if Hand is A Two of a Kind"
    (is (= true (n-of-a-kind? 2 hand-7)))
    (is (= false (n-of-a-kind? 2 hand-8)))))

(def hand-9 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :spades
               :rank 4}
              {:suit :hearts
               :rank 5}
              })

(def hand-10 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 5}
              {:suit :spades
               :rank 3}
              {:suit :hearts
               :rank 6}
              })

(deftest straight-test
  (testing "Straight Return True if Hand is a Straight"
    (is (= true (straight? hand-9)))
    (is (= false (straight? hand-10)))))

(def hand-11 #{{:suit :diamonds
                :rank 2}
               {:suit :clubs
                :rank 2}
               {:suit :spades
                :rank 4}
               {:suit :hearts
                :rank 4}
               })

(def hand-12 #{{:suit :diamonds
                :rank 2}
               {:suit :clubs
                :rank 2}
               {:suit :spades
                :rank 3}
               {:suit :hearts
                :rank 6}
               })

(deftest two-pair-test
  (testing "Two Pair Return True if Hand is a Two-Pair"
    (is (= true (two-pair? hand-11)))
    (is (= false (two-pair? hand-12)))))

(def hand-13 #{{:suit :diamonds
                :rank 2}
               {:suit :diamonds
                :rank 3}
               {:suit :diamonds
                :rank 4}
               {:suit :diamonds
                :rank 5}
               })

(def hand-14 #{{:suit :diamonds
                :rank 2}
               {:suit :clubs
                :rank 2}
               {:suit :spades
                :rank 3}
               {:suit :hearts
                :rank 6}
               })

(deftest straight-flush-test
  (testing "Straight Flush Return True if Hand is a Straight Flush"
    (is (= true (straight-flush? hand-13)))
    (is (= false (straight-flush? hand-14)))))


