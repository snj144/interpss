## Introduction ##

In stability studies, there is sometimes a need to include a detailed representation of a machine, a station or a group of machines. The standard user interface for transient stability studies allows the general form of study to be performed with minimal customization, however it is recognized that there may often be a need to represent a controller type or particular station configuration that the standard InterPSS release has not included.

InterPSS is designed to be extended to allow the user to modify the environment according to their particular requirements and is therefore a useful tool in such cases. You can find an overview of the InterPSS [Here](http://docs.google.com/View?docid=dz384d8_0chz25v).

This project is intended to illustrate how a user might extend the standard functions of InterPSS to simulate a complex station, with a cascade-hybrid style of excitation system that includes an example under excitation limiter. To further illustrate the flexibility of the InterPSS system, the station being simulated includes a simple form of cross compounding between machines.

The project is simplified, in so far as the intended purpose is to demonstrate the power of some of the concepts used and should not be interpreted as a complete representation of all the functionality that can be included. Rather, the project team hope to stimulate the imagination and show by example one possible scenario how the extensibility of InterPSS can be used for your own benefit.


## Project Description ##

The detailed project description can be found [Here](http://docs.google.com/View?docid=dd7m5rrq_0g5kwpf). The following is a brief summary:

A two machine station will be represented in detail. The network will be represented by the station feeding an infinite bus through a simple line impedance.

The machines are 50Hz turbo generators, with a train of rotating exciter machines coupled directly to the main machine shaft of medium length.
The excitation system is representative of a cascade-hybrid design that is becoming more common as aging stations undergo control system retrofits.

For this project we will consider that each machine has:
- A pilot exciter alternator (100Hz AC), the output voltage of the pilot exciter is regulated by a simple shunt connected AVR system.
- A main exciter alternator (100Hz AC), the main exciter field is controlled by an HIR AVR with PSS and an under excitation limiter (rotor-angle limit). We will include consideration of the pilot exciter output voltage being the source for the main exciter AVR controller (Cascade of controllers).
- Each machine feeds a common HV bus through a dedicated step-up transformer equipped with On Load Tap Changing. For our example the transformers have different parameters.
- A cross current compounding scheme will be shown as an illustrative example.

The project developed uses data from an actual plant and controllers that are available today. Although the connected network has been greatly simplified, this is in no way inconsistent for the demonstration purposes.
To ensure the presentation is realistic, the model outputs are being compared with actual recordings from site tests where possible.

## Our Solution ##
InterPSS has an extension plugin architecture. InterPSS also provides a scripting environment. We are going to extend InterPSS by using Java to develop some custom components and Java Script to glue these components together  to solve the problem. Also, we will solve the problem in a generic way so that the method could apply to model any generation station dynamics for transient stability simulation. You can find project solution design document [Here](http://docs.google.com/View?docid=dz384d8_3g8tmz7).

## Project Team Member ##
Current the project has the following team members:

```
Mike Zhou (mike@interpss.org)
Ron Oosterwijk (oosterwijk.ron@gmail.com)
```

## Reference Documents ##

  1. [Cascaded Regulator Modeling With InterPSS](http://docs.google.com/View?docid=dd7m5rrq_0g5kwpf)
  1. [A Generic Approach to Model Generation Station Dynamics for Transient Stability Simulation](http://docs.google.com/View?docid=dz384d8_3g8tmz7)
  1. [InterPSS - A New Power System Simulation Experience](http://docs.google.com/View?docid=dz384d8_0chz25v)