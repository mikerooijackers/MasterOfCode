angular.module('competitorClientApp').service('InformationService', function() {
    this.roundBusy = false;
    
    this.hints = [];
    
    this.assignCreatorName = "";
    this.assignCreatorCompany = "";
    this.assignCreatorWeb = "";
    
    this.assignName = "";
    this.assignDescriptionCompetitors = "";
    this.assignDescriptionSpectators = "";
    
    this.assignDifficulty = -1;
    
    this.sourceFiles = [];
    
    this.lastCompileResult = "";
    
    this.lastTestsResult = "";
    
    this.teamActions = [];
    
    this.userTests = [];
    
    this.user = null;
    
    this.isCompiling = false;
    this.isTesting = false;
});