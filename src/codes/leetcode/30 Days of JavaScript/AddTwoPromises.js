/**
 * @param {Promise<number>} promise1
 * @param {Promise<number>} promise2
 * @return {Promise}
 */
async function addTwoPromises(promise1, promise2) {
  const promise = await Promise.all([promise1, promise2]);
  return promise[0] + promise[1];
}

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */
