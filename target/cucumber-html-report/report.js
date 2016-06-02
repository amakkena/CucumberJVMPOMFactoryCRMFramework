$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SampleFeature.feature");
formatter.feature({
  "line": 1,
  "name": "Sample feature",
  "description": "",
  "id": "sample-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9708927075,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Simple Scenario_one",
  "description": "",
  "id": "sample-feature;simple-scenario-one",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "This is simple given step",
  "keyword": "Given "
});
formatter.match({
  "location": "SimpleTest.sampleTest()"
});
formatter.result({
  "duration": 1472085235,
  "status": "passed"
});
formatter.after({
  "duration": 1583388362,
  "status": "passed"
});
formatter.before({
  "duration": 5728093621,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Simple Scenario_two",
  "description": "",
  "id": "sample-feature;simple-scenario-two",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "This is simple given step",
  "keyword": "Given "
});
formatter.match({
  "location": "SimpleTest.sampleTest()"
});
formatter.result({
  "duration": 1111924975,
  "status": "passed"
});
formatter.after({
  "duration": 1348841438,
  "status": "passed"
});
});