<template lang="html">
  <div>
    <v-btn class="primary" @click.native.stop="dialog = true">Open Dialog</v-btn>
    <v-dialog v-model="dialog" max-width="800px">
      <v-card>
        <v-card-title style="left:50%; margin-left:250px;">
          <img src="../assets/박수.png">
          <img src="../assets/박수.png">
          <img src="../assets/박수.png">
        </v-card-title>
        <v-card-text class="display-1" style="text-align: left;">
          <p style="left:50%; margin-left:150px;">
            짝짝짝!! <br>
            당신은 고독한 평론가 ! <br>
            또 다른 리뷰를 남기러 가볼까요?
          </p>
        </v-card-text>
      </v-card>
    </v-dialog>
  </div>

</template>

<script>
export default {
  name: "HasNoRecommend",
  data: function(){
    return{
      dialog : false
    }
  }
}
</script>

<style lang="css">
</style>
