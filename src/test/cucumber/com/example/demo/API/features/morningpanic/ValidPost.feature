Feature: Valid POST Requests
    Scenario: Only data section success
        When the following JSON response is sent
        """
        {
            "history_length" : 5,
            "date" : "2020-07-10",

            "data" : {
                "symbol" : "UAVS",
                "sector" : "Drone",
                "drop_point" : 1.62,
                "drop_time" : "8:30",
                "bottom_tick" : 1.55,
                "bottom_time" : "8:36",
                "top_tick" : 1.75,
                "top_time" : "8:41",
                "premarket_high" : 1.65,
                "premarket_high_time" : "7:27",
                "premarket_low_after_high" : 1.59,
                "premarket_low_after_high_time" : "8:01"
            }
        }
        """
        Then the response code is 201
        And the body is "Success"


    Scenario: Data section, key levels and technical indicator behavior sections success
        When the following JSON response is sent
        """
        {
            "history_length" : 5,
            "date" : "2020-07-10",

            "data" : {
                "symbol" : "UAVS",
                "sector" : "Drone",
                "drop_point" : 1.62,
                "drop_time" : "8:30",
                "bottom_tick" : 1.55,
                "bottom_time" : "8:36",
                "top_tick" : 1.75,
                "top_time" : "8:41",
                "premarket_high" : 1.65,
                "premarket_high_time" : "7:27",
                "premarket_low_after_high" : 1.59,
                "premarket_low_after_high_time" : "8:01"
            },

            "key_levels" : [
                {
                    "price" : 1.50,
                    "type" : "Resistance"
                },
                {
                    "price" : 2.51,
                    "type" : "Breakout"
                }
            ],

            "technical_indicator_behaviors" : [
                {
                    "price" : 1.77,
                    "time" : "9:13",
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
        Then the response code is 201
        And the body is "Success"