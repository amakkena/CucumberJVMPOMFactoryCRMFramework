$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SampleFeature.feature");
formatter.feature({
  "line": 1,
  "name": "Sample feature",
  "description": "",
  "id": "sample-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 17615126309,
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
  "duration": 9804980115,
  "status": "passed"
});
formatter.after({
  "duration": 824563003,
  "status": "passed"
});
formatter.before({
  "duration": 16821665191,
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
  "duration": 6888486037,
  "status": "passed"
});
formatter.after({
  "duration": 1437742040,
  "status": "passed"
});
});