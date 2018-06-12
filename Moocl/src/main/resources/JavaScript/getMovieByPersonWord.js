function (personId,clickWord,condition,grade) {
var actorMovie= [];
var reviewer_list = [];
var movie_list = [];    
db.movie_info.aggregate([
    
db.test_review.aggregate([
	
	
	db.test_review.aggregate([ {$project : {"user_grade" : 1}},
	    {$match : {"_id.user_id" : {$in :reviewer_list}}}, 
	    {$match : {"user_grade" : {$gte : grade}}}, 
	    {$group : {_id :"$_id.movie_ref", 
	               count:{$sum :1 }}},
	    {$sort : {"count" : -1}},
	    {$limit : 11}
	    ]).forEach(function(doc) {

return movie_list
}