Feature: Invalid POST Requests: Pullback_Bounces



  # drop
  Scenario: Invalid pullback_bounces.drop.price
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

            "pullback_bounces" : [
                {
                  "drop" : {
                      "price" : -1.60,
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
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid pullback_bounces.drop.price"


  Scenario: Invalid pullback_bounces.drop.time
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

            "pullback_bounces" : [
                    {
                    "drop" : {
                        "price" : 1.60,
                        "time" : "8:38a"
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
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid pullback_bounces.drop.time"

  Scenario: Invalid pullback_bounces.drop.significance
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

            "pullback_bounces" : [
                    {
                    "drop" : {
                        "price" : 1.60,
                        "time" : "8:38",
                        "significance" : "Blueberries"
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
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid pullback_bounces.drop.significance"



    # bottom
  Scenario: Invalid pullback_bounces.bottom.price
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

            "pullback_bounces" : [
                    {
                    "drop" : {
                        "price" : 1.60,
                        "time" : "8:38"
                    },
                    "bottom" : {
                        "price" : -1.57,
                        "time" : "8:39"
                    },
                    "top" : {
                        "price" : 1.75,
                        "time" : "8:41"
                    }
                }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid pullback_bounces.bottom.price"


  Scenario: Invalid pullback_bounces.bottom.time
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

            "pullback_bounces" : [
                    {
                    "drop" : {
                        "price" : 1.60,
                        "time" : "8:38"
                    },
                    "bottom" : {
                        "price" : 1.57,
                        "time" : "a8:39"
                    },
                    "top" : {
                        "price" : 1.75,
                        "time" : "8:41"
                    }
                }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid pullback_bounces.bottom.time"


  Scenario: Invalid pullback_bounces.bottom.significance
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

            "pullback_bounces" : [
                    {
                    "drop" : {
                        "price" : 1.60,
                        "time" : "8:38"
                    },
                    "bottom" : {
                        "price" : 1.57,
                        "time" : "8:39",
                        "significance" : "DD"
                    },
                    "top" : {
                        "price" : 1.75,
                        "time" : "8:41"
                    }
                }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid pullback_bounces.bottom.significance"



    # top
  Scenario: Invalid pullback_bounces.top.price
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
                        "price" : -1.75,
                        "time" : "8:41"
                    }
                }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid pullback_bounces.top.price"


  Scenario: Invalid pullback_bounces.top.time
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
                        "time" : "8:41a"
                    }
                }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid pullback_bounces.top.time"



  Scenario: Invalid pullback_bounces.top.significance
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
                        "time" : "8:41",
                        "significance" : " dfAF"
                    }
                }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid pullback_bounces.top.significance"