<template lang="html">
      <v-card class="ma-0 ml-3" @mouseenter="showButton" @mouseleave="hideButton" depressed width="168" height="240" :img ="posterUrl">
        <v-card-media>
          <v-flex xs10></v-flex>   <!-- 하트를 오른쪽 보내기 위한 테그 -->
          <v-flex xs3>
            <!--버튼 눌렀을때 favorite 목록에 추가되는 기능 필요  -->
            <v-btn :ripple="false" v-show="showFB" flat icon small @click="favorite = !favorite" depressed>
                <v-icon color="red accent-3">{{favorite ? "favorite" : "favorite_border"}}</v-icon>
            </v-btn>
          </v-flex>
        </v-card-media>
      </v-card>
</template>

<script>
export default {
  name: "SmallMoviePoster",
  props: ['posterUrl'],
  data : function() {
    return{
      favorite: false,
      showFB: false,
    }
  },
  methods : {
    showButton : function(e) {
      this.showFB =true;
    },
    hideButton : function(e) {
      this.showFB = false;
    }
  }
}
</script>

<style lang="css">
</style>
