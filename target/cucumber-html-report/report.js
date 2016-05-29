$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SampleFeature.feature");
formatter.feature({
  "line": 1,
  "name": "Sample feature",
  "description": "",
  "id": "sample-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 24395769063,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Simple Scenario",
  "description": "",
  "id": "sample-feature;simple-scenario",
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
  "duration": 30952263380,
  "status": "passed"
});
});