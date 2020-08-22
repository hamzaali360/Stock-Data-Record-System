Feature: Invalid POST Requests: Technical_Indicator_Behavior

  Scenario: Invalid technical_indicator_behavior.price
    When the following JSON response is sent
        """
        {
            "data" : {
                "symbol" : "UAVS",
                "sector" : "Drone",
                "history_length" : 5,
                "date" : "2020-07-10"
            },
            
            "premarket" : {
                "high" : {
                    "price" : 1.65,
                    "time" : "7:27"
                },
                "low_after_high" : {
                    "price" : 1.59,
                    "time" : "8:01"
                }
            },

            "main_panic_bounce" : {
                "drop" : {
                    "price" : 1.62,
                    "time" : "8:30"
                },
                "bottom" : {
                    "price" : 1.55,
                    "time" : "8:36"
                },
                "top" : {
                    "price" : 1.75,
                    "time" : "8:41"
                }
            },

            "technical_indicator_behaviors" : [
              {
                "price" : -1.80,
                "time" : "9:20",
                "type" : "VWAP Bounce"
              }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid technical_indicator_behaviors.price"

  Scenario: Invalid technical_indicator_behavior.type
    When the following JSON response is sent
        """
        {
            "data" : {
               "symbol" : "UAVS",
                "sector" : "Drone",
                "history_length" : 5,
                "date" : "2020-07-10"
            },

            "premarket" : {
                "high" : {
                    "price" : 1.65,
                    "time" : "7:27"
                },
                "low_after_high" : {
                    "price" : 1.59,
                    "time" : "8:01"
                }
            },

            "main_panic_bounce" : {
                "drop" : {
                    "price" : 1.62,
                    "time" : "8:30"
                },
                "bottom" : {
                    "price" : 1.55,
                    "time" : "8:36"
                },
                "top" : {
                    "price" : 1.75,
                    "time" : "8:41"
                }
            },

            "technical_indicator_behaviors" : [
                {
                    "price" : 1.77,
                    "time" : "9:13",
                    "type" : "Spot"
                },
                {
                    "price" : 1.80,
                    "time" : "9:20",
                    "type" : "VWAP Bounce"
                }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid technical_indicator_behaviors.type"


  Scenario: Invalid technical_indicator_behavior.time
    When the following JSON response is sent
        """
        {
            "data" : {
               "symbol" : "UAVS",
                "sector" : "Drone",
                "history_length" : 5,
                "date" : "2020-07-10"
            },

            "premarket" : {
                "high" : {
                    "price" : 1.65,
                    "time" : "7:27"
                },
                "low_after_high" : {
                    "price" : 1.59,
                    "time" : "8:01"
                }
            },

            "main_panic_bounce" : {
                "drop" : {
                    "price" : 1.62,
                    "time" : "8:30"
                },
                "bottom" : {
                    "price" : 1.55,
                    "time" : "8:36"
                },
                "top" : {
                    "price" : 1.75,
                    "time" : "8:41"
                }
            },

            "technical_indicator_behaviors" : [
                {
                    "price" : 1.77,
                    "time" : "9:13a",
                    "type" : "Bullish VWAP Crossover"
                },
                {
                    "price" : 1.80,
                    "time" : "9:20",
                    "type" : "VWAP Bounce"
                }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid technical_indicator_behaviors.time"