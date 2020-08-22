Feature: Invalid POST Requests: Failed_Morning_Spikes


  ### start ###
  Scenario: Invalid failed_morning_spikes.start.price
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

            "failed_morning_spikes" : [
              {
              "start" : {
                "price" : -1.60,
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
    Then the response code is 400
    And the body is for an "Invalid failed_morning_spikes.start.price"

  Scenario: Invalid failed_morning_spikes.start.time
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

            "failed_morning_spikes" : [
              {
              "start" : {
                "price" : 1.60,
                "time" : "a8:31"
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
    Then the response code is 400
    And the body is for an "Invalid failed_morning_spikes.start.time"


  Scenario: Invalid failed_morning_spikes.start.significance
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

            "failed_morning_spikes" : [
              {
              "start" : {
                "price" : 1.60,
                "time" : "8:31",
                "significance" : "ADF"
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
    Then the response code is 400
    And the body is for an "Invalid failed_morning_spikes.start.significance"



    ### top ###
  Scenario: Invalid failed_morning_spikes.top.price
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

            "failed_morning_spikes" : [
              {
              "start" : {
                "price" : 1.60,
                "time" : "8:31"
              },
              "top" : {
                "price" : -1.66,
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
    Then the response code is 400
    And the body is for an "Invalid failed_morning_spikes.top.price"

  Scenario: Invalid failed_morning_spikes.top.time
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

            "failed_morning_spikes" : [
              {
              "start" : {
                "price" : 1.60,
                "time" : "8:31"
              },
              "top" : {
                "price" : 1.66,
                "time" : "8:a32"
              },
              "bottom" : {
                "price" : 1.55,
                "time" : "8:36"
              }
            }
          ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_morning_spikes.top.time"


  Scenario: Invalid failed_morning_spikes.top.significance
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

            "failed_morning_spikes" : [
              {
              "start" : {
                "price" : 1.60,
                "time" : "8:31"
              },
              "top" : {
                "price" : 1.66,
                "time" : "8:32",
                "significance" : "ASDFA"
              },
              "bottom" : {
                "price" : 1.55,
                "time" : "8:36"
              }
            }
          ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_morning_spikes.top.significance"


    ### bottom ###
  Scenario: Invalid failed_morning_spikes.bottom.price
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
                "price" : -1.55,
                "time" : "8:36"
              }
            }
          ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_morning_spikes.bottom.price"

  Scenario: Invalid failed_morning_spikes.bottom.time
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
                "time" : "a8:36"
              }
            }
          ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_morning_spikes.bottom.time"


  Scenario: Invalid failed_morning_spikes.bottom.significance
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
                "time" : "8:36",
                "significance" : "adsF"
              }
            }
          ]

        }
        """
    Then the response code is 400
    And the body is for an "Invalid failed_morning_spikes.bottom.significance"