Purpose
=======

A simple game and engine in Java &amp; Swing.


Purpose is an exercise in building a Java game with zero dependencies. While no dependencies is nice, the mission is to explore stable game loop creation, rendering strategies, and state machine design. Notes extracted from the source can be found below.


Time Delta Emissions from the Game Loop
---------------------------------------
The delta value will arrive as a long type. When calculating how much another value has changed over time, follow these steps:

1. Promote delta to float.
2. Divide delta by 1,000 - demoting it to a seconds value.
3. Multiply delta by the rate of change (in per-second format) of the value under simulation.
4. Use this calculated value to mutate the "position in time" of the value under simulation.

For example, suppose we have a player moving at 100 units per second. Our simulation just ticked another 20ms (50 ticks per second):

1. delta is 20ms
2. delta/1000 is 0.02 seconds
3. delta * speed is 2.0
4. player.x += 2.0


Coordinate Translation
----------------------

Because Swing's origin is top-left, we will need to either flip the entire coordinate system at run-time or build helper functions to translate our virtual coordinates to on-screen coordinates. For now, I've used the former strategy as performance isn't a concern at the moment.

The translation:

(0,0) (+,0) -> (0,+) (+,+)
(0,+) (+,+) -> (0,0) (+,0)
