Feature: Invalid POST Requests: Key_Levels

  Scenario: Invalid key_levels.price
    When the following JSON response is sent
        """
        {
            "history_length" : 5,
            "date" : "2020-07-10",

            "data" : {
               "symbol" : "UAVS",
                "sector" : "Drone",

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

                "panic_bounce" : {
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
                }
            },

            "key_levels" : [
                {
                    "price" : -2.51,
                    "type" : "Breakout"
                }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid key_levels.price"

  Scenario: Invalid key_level.type
    When the following JSON response is sent
        """
        {
            "history_length" : 5,
            "date" : "2020-07-10",

            "data" : {
               "symbol" : "UAVS",
                "sector" : "Drone",

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

                "panic_bounce" : {
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
                }
            },

            "key_levels" : [
                {
                    "price" : 1.50,
                    "type" : "Spot"
                },
                {
                    "price" : 2.51,
                    "type" : "Breakout"
                }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid key_levels.type"
