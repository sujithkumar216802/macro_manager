# macro_manager
This app is used to automate tasks

## Trigger

This initiates a macro(set of instructions).
Triggers are a particular set of actions that initiate a macro

## Constraints

The macro executes when all constraints are met

## Action

Tasks that are executed when a macro is executed

## About

* MVVM architecturer
* Room to save macros
* Broadcast receivers to start a macro execution
* service to keep the process running in the background

## TO-DO

- [x] Room database
- [X] Addition and deletion and editing macros
- [x] service to run the app in background
- [ ] Actions , constraints and triggers requiring special permission
- [ ] cloud backup of macros
- [ ] dynamic seearch


##### Triggers

- [ ] battery
- [x] password failed
- [x] charger connected
- [x] charger disconnected
- [x] screen on
- [x] screen off
- [X] time
- [X] day of the week
- [X] day of the month
- [ ] new app installed
- [ ] app deleted


##### Constraints

- [x] battery level
- [x] charging state
- [x] battery temperature
- [x] month
- [X] month day
- [x] day of the week
- [x] autorotate
- [x] headphones
- [x] screenstate
- [x] orientation


##### Actions

- [X] delay
- [X] vibrate
- [x] clipboard
- [x] launch homescreen
- [x] volume
- [x] vibrate/ringer mode
- [ ] kill background apps
- [x] custom notification
- [x] custom toast




