//recommend movie 용 vuex
import axios from 'axios'

const state = {
  goodMovieList: [],
  badMovieList: []
}

const getters = {
  getGoodMovies(state){
    return state.goodMovieList;
  },
  getBadMovies(state){
    return state.badMovieList;
  }
}

const actions = {
  GETRECOMMENDATION : function({commit}, keyValue) {
    return new Promise(function(resolve, reject) {
      axios.get("/api/getRecommendMovie", {
        params : {
          movieId : keyValue.movieId,
          clickWord : keyValue.word
        }
      })
      .then((result) => {
        let movies = result.data;
        console.log(movies);
        resolve('영화 목록 받아옴');
        commit('SETRECOMMENDATION', movies);
      }, error => {
        reject(error);
      })
    });
  }
}

const mutations = {
  SETRECOMMENDATION : function(state, movies){
    console.log("mutation");
    console.log(movies);
    let goodMovies = movies.good;
    let badMovies = movies.bad;

    state.goodMovieList = goodMovies;
    state.badMovieList = badMovies;
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}
