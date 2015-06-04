angular.module('competitorClientApp').service('InformationService', function() {
    this.hints = [];
    
    this.assignCreatorName = "";
    this.assignCreatorCompany = "";
    this.assignCreatorWeb = "";
    
    this.assignName = "";
    this.assignDescriptionCompetitors = "";
    this.assignDescriptionSpectators = "";
    
    this.sourceFiles = [];
    
    this.lastCompileResult = "";
});