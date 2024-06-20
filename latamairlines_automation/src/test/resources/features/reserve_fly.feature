Feature: Reserve a flight
  As a user on the LATAM Airlines platform
  I want to reserve a flight
  So that I can travel and enjoy

  Scenario Outline: Successfully reserve a flight
    Given the user is on the LATAM Airlines platform using "<webBrowser>"
    When the user reserves a flight with following details
      | from   | to   | daysAhead   | nAdults   | nChildren   |
      | <from> | <to> | <daysAhead> | <nAdults> | <nChildren> |
    And confirms the preferences
    Then the user should see a confirmation message
    Examples:
      | webBrowser | from     | to     | daysAhead | nAdults | nChildren |
      #| chrome     | Miami | Bogota    | 5         | 2       | 1         |
      #| edge       | Lima  | Quito     | 10        | 1       | 0         |
      | edge       | Medellin | Bogota | 15        | 3       | 2         |
