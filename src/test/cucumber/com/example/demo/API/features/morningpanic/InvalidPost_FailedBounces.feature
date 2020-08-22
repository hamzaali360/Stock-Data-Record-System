Feature: Invalid POST Requests: Failed_Bounces

    ### drop ###
  Scenario: Invalid failed_bounces.drop.price
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
                    "price" : -1.62,
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
            ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_bounces.drop.price"


  Scenario: Invalid failed_bounces.drop.time
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
                        "time" : "a8:30"
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
            ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_bounces.drop.time"



  Scenario: Invalid failed_bounces.drop.significance
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
                        "time" : "8:30",
                        "significance" : "adf"
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
            ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_bounces.drop.significance"



    ### bottom ###
  Scenario: Invalid failed_bounces.bottom.price
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
                        "price" : -1.57,
                        "time" : "8:32"
                    },
                    "top" : {
                        "price" : 1.60,
                        "time" : "8:33"
                    }
                }
            ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_bounces.bottom.price"


  Scenario: Invalid failed_bounces.bottom.time
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
                    "time" : "8a:36"
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
                        "time" : "8:a32"
                    },
                    "top" : {
                        "price" : 1.60,
                        "time" : "8:33"
                    }
                }
            ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_bounces.bottom.time"



  Scenario: Invalid failed_bounces.bottom.significance
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
                    "time" : "8a:36"
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
                        "time" : "8:32",
                        "significance" : "ASDF"
                    },
                    "top" : {
                        "price" : 1.60,
                        "time" : "8:33"
                    }
                }
            ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_bounces.bottom.significance"



    ### top ###
  Scenario: Invalid failed_bounces.top.price
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
                        "price" : -1.60,
                        "time" : "8:33"
                    }
                }
            ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_bounces.top.price"


  Scenario: Invalid failed_bounces.top.time
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
                        "time" : "a8:33"
                    }
                }
            ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_bounces.top.time"


  Scenario: Invalid failed_bounces.top.significance
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
                        "time" : "8:33",
                        "significance" : "ADSF"
                    }
                }
            ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_bounces.top.significance"