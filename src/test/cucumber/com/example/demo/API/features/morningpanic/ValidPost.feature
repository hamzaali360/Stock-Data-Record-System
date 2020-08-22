Feature: Valid POST Requests
    Scenario: Only data section success
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
                    "time" : "8:36",
                    "significance" : "Support"
                },
                "top" : {
                    "price" : 1.75,
                    "time" : "8:41"
                }
            }
        }
        """
        Then the response code is 201
        And the body is "Success"


    Scenario: Data and catalyst sections success
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

            "catalysts" : [
                {
                    "date" : "2020-07-10",
                    "time" : "7:27",
                    "description" : "Won a contract"
                }
            ]
        }
        """
        Then the response code is 201
        And the body is "Success"


    Scenario: Data section, key levels and technical indicator behavior sections success
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

            "key_levels" : [
                {
                    "price" : 1.50,
                    "time" : "8:35",
                    "type" : "Resistance"
                },
                {
                    "price" : 2.51,
                    "time" : "8:40",
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


    Scenario: Data section, key levels, technical indicator behavior, failed bounces and pullback bounces sections success
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

            "failed_bounces" : [
                {
                    "drop" : {
                        "price" : 1.62,
                        "time" : "8:30"
                    },
                    "bottom" : {
                        "price" : 1.57,
                        "time" : "8:32"
                    },
                    "top" : {
                        "price" : 1.60,
                        "time" : "8:33"
                    }
                }
            ],

            "pullback_bounces" : [
                    {
                    "drop" : {
                        "price" : 1.60,
                        "time" : "8:38"
                    },
                    "bottom" : {
                        "price" : 1.57,
                        "time" : "8:39"
                    },
                    "top" : {
                        "price" : 1.75,
                        "time" : "8:41"
                    }
                }
            ],

            "key_levels" : [
                {
                    "price" : 1.50,
                    "time" : "8:35",
                    "type" : "Resistance"
                },
                {
                    "price" : 2.51,
                    "time" : "8:40",
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


    Scenario: Data section, key levels, technical indicator behavior, failed bounces, pullback bounces and failed spikes sections success
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

            "failed_bounces" : [
                {
                    "drop" : {
                        "price" : 1.62,
                        "time" : "8:30"
                    },
                    "bottom" : {
                        "price" : 1.57,
                        "time" : "8:32"
                    },
                    "top" : {
                        "price" : 1.60,
                        "time" : "8:33"
                    }
                }
            ],

            "pullback_bounces" : [
                    {
                    "drop" : {
                        "price" : 1.60,
                        "time" : "8:38"
                    },
                    "bottom" : {
                        "price" : 1.57,
                        "time" : "8:39"
                    },
                    "top" : {
                        "price" : 1.75,
                        "time" : "8:41"
                    }
                }
            ],

            "key_levels" : [
                {
                    "price" : 1.50,
                    "time" : "8:35",
                    "type" : "Resistance"
                },
                {
                    "price" : 2.51,
                    "time" : "8:40",
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
            ],

            "failed_morning_spikes" : [
                {
                    "start" : {
                        "price" : 1.60,
                        "time" : "8:31"
                    },
                    "top" : {
                        "price" : 1.66,
                        "time" : "8:32"
                    },
                    "bottom" : {
                        "price" : 1.55,
                        "time" : "8:36"
                    }
                }
            ]
        }
        """
        Then the response code is 201
        And the body is "Success"