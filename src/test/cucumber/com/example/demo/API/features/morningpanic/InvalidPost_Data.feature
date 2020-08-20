Feature: Invalid POST Requests: Data

  Scenario: Invalid history_length
    When the following JSON response is sent
        """
        {
            "history_length" : 1000000,
            "date" : "2020-07-10",

            "data" : {
            "   symbol" : "UAVS",
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
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid history_length"


  Scenario: Invalid date
    When the following JSON response is sent
        """
        {
            "history_length" : 5,
            "date" : "date",

            "data" : {
            "   symbol" : "UAVS",
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
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid date"


  Scenario: Invalid data.symbol
    When the following JSON response is sent
        """
        {
            "history_length" : 5,
            "date" : "2020-07-10",

            "data" : {
                "symbol" : "UAVS1",
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
            }
        }

        """
    Then the response code is 400
    And the body is for an "Invalid data.symbol"


  Scenario: Invalid premarket.high.price
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
                        "price" : -1.65,
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
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid data.premarket.high.price"


  Scenario: Invalid premarket.high.time
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
                        "time" : "71:27"
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
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid data.premarket.high.time"


  Scenario: Invalid premarket.low_after_high.price
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
                        "price" : -1.59,
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
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid data.premarket.low_after_high.price"


  Scenario: Invalid premarket.low_after_high.time
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
                        "time" : "a8:01"
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
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid data.premarket.low_after_high.time"




  Scenario: Invalid data.panic_bounce_drop.price
    When the following JSON response is sent
        """
        {
            "history_length" : 5,
            "date" : "2020-07-10",

            "data" : {
            "   symbol" : "UAVS",
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
        }
        """
    Then the response code is 400
    And the body is for an "Invalid data.panic_bounce.drop.price"


  Scenario: Invalid data.panic_bounce.drop.time
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
        }
        """
    Then the response code is 400
    And the body is for an "Invalid data.panic_bounce.drop.time"


  Scenario: Invalid data.panic_bounce.bottom.price
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
                        "price" : -1.55,
                        "time" : "8:36"
                    },
                    "top" : {
                        "price" : 1.75,
                        "time" : "8:41"
                    }
                }
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid data.panic_bounce.bottom.price"


  Scenario: Invalid data.panic_bounce.bottom.time
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
                        "time" : "8:3a6"
                    },
                    "top" : {
                        "price" : 1.75,
                        "time" : "8:41"
                    }
                }
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid data.panic_bounce.bottom.time"


  Scenario: Invalid data.panic_bounce.top.price
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
                        "price" : -1.75,
                        "time" : "8:41"
                    }
                }
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid data.panic_bounce.top.price"


  Scenario: Invalid data.panic_bounce.top.time
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
                        "time" : "8a:41"
                    }
                }
            }
        }
        """
    Then the response code is 400
    And the body is for an "Invalid data.panic_bounce.top.time"


