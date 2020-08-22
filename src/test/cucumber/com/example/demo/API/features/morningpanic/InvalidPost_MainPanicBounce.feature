Feature: Invalid POST Requests: Main Panic Bounce

  ### drop ###
  Scenario: Invalid main_panic_bounce_drop.price
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
                    "price" : -1.62,
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
        }
        """
    Then the response code is 400
    And the body is for an "Invalid main_panic_bounce.drop.price"


  Scenario: Invalid main_panic_bounce.drop.time
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
                    "time" : "8a:30"
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
        }
        """
    Then the response code is 400
    And the body is for an "Invalid main_panic_bounce.drop.time"


  Scenario: Invalid main_panic_bounce.drop.significance
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
                    "time" : "8:30",
                    "significance" : "ADF"
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
        }
        """
    Then the response code is 400
    And the body is for an "Invalid main_panic_bounce.drop.significance"



    ### bottom ###
  Scenario: Invalid main_panic_bounce.bottom.price
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
                    "price" : -1.55,
                    "time" : "8:36"
                },
                "top" : {
                    "price" : 1.75,
                    "time" : "8:41"
                }
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid main_panic_bounce.bottom.price"


  Scenario: Invalid main_panic_bounce.bottom.time
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
                    "time" : "8:3a6"
                },
                "top" : {
                    "price" : 1.75,
                    "time" : "8:41"
                }
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid main_panic_bounce.bottom.time"


  Scenario: Invalid main_panic_bounce.bottom.significance
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
                    "significance" : "AFDS"
                },
                "top" : {
                    "price" : 1.75,
                    "time" : "8:41"
                }
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid main_panic_bounce.bottom.significance"


    ### top ###
  Scenario: Invalid main_panic_bounce.top.price
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
                    "price" : -1.75,
                    "time" : "8:41"
                }
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid main_panic_bounce.top.price"


  Scenario: Invalid main_panic_bounce.top.time
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
                    "time" : "8a:41"
                }
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid main_panic_bounce.top.time"

  Scenario: Invalid main_panic_bounce.top.significance
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
                    "time" : "8:41",
                    "significance" : "ADF"
                }
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid main_panic_bounce.top.significance"